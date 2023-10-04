package com.docuscore.docs.Controller;

import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/OCR")
public class OCRController {

    static {
        // Load OpenCV library
        OpenCV.loadLocally();
    }

    @PostMapping("/getTextGVision")
    public Score getTextGVision(@RequestParam("imageFile") MultipartFile file) throws IOException {
        String result = "";

        try(ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {
//            convert file to byte array
            byte[] byteArray = file.getBytes();
            ByteString imgBytes = ByteString.copyFrom(byteArray);
//            Builds the image annotation request
            List<AnnotateImageRequest> requests = new ArrayList<>();
            Image img = Image.newBuilder().setContent(imgBytes).build();
            Feature feature= Feature.newBuilder().setType(Feature.Type.DOCUMENT_TEXT_DETECTION).build();
            AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
                    .addFeatures(feature).setImage(img).build();
            requests.add(request);
//            Performs label detection on the image file
            BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();
            vision.close();
            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.format("Error: %s%n", res.getError().getMessage());
                    return new Score();
                }
                TextAnnotation textAnnotation = res.getFullTextAnnotation();
                result = textAnnotation.getText();
            }
        }
        Score score = new Score();
        result = result.replaceAll(" ", "");
        result = result.replaceAll("o|O", "0");
        String[] temp = result.split("-");
        score.setStudent(Integer.parseInt(temp[0]));
        score.setScore(Integer.parseInt(temp[1]));
        return score;
    }

    @PostMapping("/getTextTess")
    public String getTextTess(@RequestParam("imageFile") MultipartFile file){
        try {

            Mat image = cleanImage(file);
            // Convert Mat image to BufferedImage
            MatOfByte matOfByte = new MatOfByte();
            Imgcodecs.imencode(".jpg", image, matOfByte);
            //Storing the encoded Mat in a byte array
            byte[] byteArray = matOfByte.toArray();
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(byteArray));

            // retrieve image
            File outputfile = new File("saved.png");
            ImageIO.write(bufferedImage, "png", outputfile);

            //tesseract instance
            ITesseract tesseract = new Tesseract();
            //data path for tess4J tessdata
            tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");

            //extract text
            return tesseract.doOCR(bufferedImage);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error extracting text from image";
        }
    }

    public Mat cleanImage(MultipartFile file) throws IOException {
        // Read image as a byte array
        byte[] fileBytes = file.getBytes();

        // Create a Mat object from the byte array
        Mat image = Imgcodecs.imdecode(new MatOfByte(fileBytes), Imgcodecs.IMREAD_GRAYSCALE);

        // Thresholding
        Imgproc.threshold(image, image, 120, 255, Imgproc.THRESH_TOZERO);

        // Smoothing
        Imgproc.GaussianBlur(image, image, new org.opencv.core.Size(3, 3), 0);

        // Morphological opening
        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new org.opencv.core.Size(3, 3));
        Imgproc.morphologyEx(image, image, Imgproc.MORPH_OPEN, kernel);

        return image;
    }


}

class Score{
    private int student;
    private int score;

    public Score() {
    }

    public Score(int student, int score) {
        this.student = student;
        this.score = score;
    }

    public int getStudent() {
        return student;
    }

    public int getScore() {
        return score;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
