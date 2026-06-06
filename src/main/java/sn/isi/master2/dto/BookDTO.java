package sn.isi.master2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookDTO {
    private Integer id;
    private String titre ;
    private String auteur ;
    private String price ;
    private boolean disponible;
}
