package masjidmuar.project.bms.exception;

public class inputNotFoundException  extends RuntimeException{
    public inputNotFoundException(Long id){
        super("Could not found the input with id "+ id);
    }

}
