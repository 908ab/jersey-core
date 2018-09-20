package miyakawalab.tool.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionInformation {
    private Integer status;
    private String message;
}
