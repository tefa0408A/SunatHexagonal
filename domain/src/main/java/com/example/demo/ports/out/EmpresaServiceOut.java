package com.example.demo.ports.out;

import com.example.demo.agreggates.dto.EmpresaDto;

public interface EmpresaServiceOut {
    EmpresaDto createEmpresaOut(String ruc);
}
