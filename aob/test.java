import java.time.LocalDateTime;
import java.lang.Integer;
import java.time.format.DateTimeFormatter;


public class Main{
	public static void main(String [] args){

		LocalDateTime appointmentDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		String t = appointmentDate.format(formatter);
		// LocalDateTime appointmentDate = LocalDateTime.parse();
        // String d = appointmentDate.toLocalDate();

		System.out.println(t);
	}
}