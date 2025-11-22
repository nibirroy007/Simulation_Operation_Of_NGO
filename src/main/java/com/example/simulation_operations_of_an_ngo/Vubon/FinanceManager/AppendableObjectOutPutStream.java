package com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager;

import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutPutStream extends ObjectOutputStream {
    public AppendableObjectOutPutStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
        //
    }
}
