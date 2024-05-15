package main.com.batsworks.interfaces.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosModel {

    private Long id;
    private String nome;
    private int idade;
    private String email;
    private String endereco;
    private String senha;
    private Boolean adm;

    public static UsuariosModel rowMapper(ResultSet rs) {
        try {
            return UsuariosModel.builder().id(rs.getLong("id")).nome(rs.getString("nome"))
                    .idade(rs.getInt("idade")).email(rs.getString("email")).adm(rs.getBoolean("adm"))
                    .endereco(rs.getString("endereco")).senha(rs.getString("senha")).build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
