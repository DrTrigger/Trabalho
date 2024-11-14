package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "TipoEquipamento")
@Table(name = "tipoequipamento")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TipoEquipamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Long idTipo;

    @Column(name = "nome_tipo", nullable = false)
    private String nomeTipo;

    @Column(name = "descricao")
    private String descricao;

    // Mapeamento bidirecional, caso eu queira acessar os equipamentos deste tipo
    //@OneToMany(mappedBy = "tipoEquipamento")
    //private List<Equipamento> equipamentos;
}
