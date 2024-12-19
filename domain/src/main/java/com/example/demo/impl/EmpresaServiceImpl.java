package com.example.demo.impl;

import com.example.demo.agreggates.dto.EmpresaDto;
import com.example.demo.ports.in.EmpresaServiceIn;
import com.example.demo.ports.out.EmpresaServiceOut;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements EmpresaServiceIn {

    private final EmpresaServiceOut empresaServiceOut;

    public EmpresaServiceImpl(EmpresaServiceOut empresaServiceOut) {
        this.empresaServiceOut = empresaServiceOut;
    }

    @Override
    public EmpresaDto createEmpresaIn(String ruc) {
        return empresaServiceOut.createEmpresaOut(ruc);
    }
}
