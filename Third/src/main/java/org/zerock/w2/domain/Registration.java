package org.zerock.w2.domain;
import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
    private String mid;
    private String mpw;
    private String mname;
    private Integer age;
    private String email;
}
