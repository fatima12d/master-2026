package sn.isi.master2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MembreDto {
    private Integer id;
    private String name;
    private String telephone;
    private String email  ;
    private String address  ;
}
