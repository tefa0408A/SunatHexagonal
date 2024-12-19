package com.example.demo.adapters;

import com.example.demo.agreggates.constants.Constans;
import com.example.demo.agreggates.dto.EmpresaDto;
import com.example.demo.agreggates.response.ResponseSunat;
import com.example.demo.dao.EmpresaRepository;
import com.example.demo.entity.EmpresaEntity;
import com.example.demo.mapper.EmpresaMapper;
import com.example.demo.ports.out.EmpresaServiceOut;
import com.example.demo.rest.SunatClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmpresaAdapter implements EmpresaServiceOut {

    private final EmpresaRepository empresaRepository;
    private final SunatClient sunatClient;
    private final EmpresaMapper empresaMapper;



    @Value("${token.api}")
    private String token;

    @Override
    public EmpresaDto createEmpresaOut(String ruc) {
        EmpresaEntity empresa = getEntity(ruc);
        return empresaMapper.mapToDto(empresaRepository.save(empresa));
    }

    private EmpresaEntity getEntity(String ruc){
        ResponseSunat responseSunat = execute(ruc);
        if (Objects.nonNull(responseSunat)){
            return EmpresaEntity.builder()
                    .actividadEconomica(responseSunat.getActividadEconomica())
                    .dpto(responseSunat.getDpto())
                    .distrito(responseSunat.getDistrito())
                    .razonSocial(responseSunat.getRazonSocial())
                    .tipoDocumento(responseSunat.getTipoDocumento())
                    .numeroDocumento(responseSunat.getNumeroDocumento())
                    .estado(responseSunat.getEstado())
                    .condicion(responseSunat.getCondicion())
                    .direccion(responseSunat.getDireccion())
                    .ubigeo(responseSunat.getUbigeo())
                    .viaTipo(responseSunat.getViaTipo())
                    .viaNombre(responseSunat.getViaNombre())
                    .zonaCodigo(responseSunat.getZonaCodigo())
                    .zonaTipo(responseSunat.getZonaTipo())
                    .numero(responseSunat.getNumero())
                    .interior(responseSunat.getInterior())
                    .lote(responseSunat.getLote())
                    .manzana(responseSunat.getManzana())
                    .kilometro(responseSunat.getKilometro())
                    .provincia(responseSunat.getProvincia())
                    .departamento(responseSunat.getDepartamento())
                    .tipo(responseSunat.getTipo())
                    .numeroTrabajadores(responseSunat.getNumeroTrabajadores())
                    .tipoFacturacion(responseSunat.getTipoFacturacion())
                    .tipoContabilidad(responseSunat.getTipoContabilidad())
                    .comercioExterior(responseSunat.getComercioExterior())
                    .usua_crea(Constans.USU_ADMIN)
                    .date_crea(new Timestamp(System.currentTimeMillis()))
                    .build();
        }
        return null;
    }

    private ResponseSunat execute(String ruc){
        String head = "Bearer "+token;
        return sunatClient.getInfoSunat(ruc,head);
    }
}
