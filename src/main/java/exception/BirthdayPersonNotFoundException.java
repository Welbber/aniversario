package exception;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class BirthdayPersonNotFoundException extends RuntimeException {
    private String message;

    public BirthdayPersonNotFoundException(String message) {
        super(message);
        this.message = message;
    }

}
