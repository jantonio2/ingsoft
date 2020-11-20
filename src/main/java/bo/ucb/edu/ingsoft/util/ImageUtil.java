package bo.ucb.edu.ingsoft.util;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

public class ImageUtil {
    private Path path;
    public String uploadImage(MultipartFile image, String file, String rol, Integer userId){
        path = Paths.get(file);
        try{
            String newName = cod()+rol+String.valueOf(userId)+"."+typeImage(image.getOriginalFilename());
            Files.copy(image.getInputStream(),this.path.resolve(newName));
            return this.path.getFileName()+"/"+newName;
        }catch (Exception e){
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }

    public String cod(){
        String chars ="abcdefghijklmnopqrstuvwxyz0123456789";
        String name = "";
        for(int i=0; i<10; i++){
            name += chars.charAt((int) Math.floor(Math.random() * chars.length()));
        }
        Calendar fecha = Calendar.getInstance();
        int year = fecha.get(Calendar.YEAR);
        int month = fecha.get(Calendar.MONTH) + 1;
        int day = fecha.get(Calendar.DAY_OF_MONTH);
        int hour = fecha.get(Calendar.HOUR_OF_DAY);
        int minute = fecha.get(Calendar.MINUTE);
        int second = fecha.get(Calendar.SECOND);
        name += String.valueOf(year) + String.valueOf(month) + String.valueOf(day) + String.valueOf(hour) + String.valueOf(minute) + String.valueOf(second);
        return name;
    }

    public String typeImage (String imageName){
        String array[] = imageName.split("\\.");
        String type = array[1];
        return type;
    }

}
