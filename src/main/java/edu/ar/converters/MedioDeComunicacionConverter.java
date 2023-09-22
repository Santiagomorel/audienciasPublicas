package edu.ar.converters;

import edu.ar.Email;
import edu.ar.MedioDeComunicacion;
import edu.ar.Telegram;
import edu.ar.WhatsApp;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MedioDeComunicacionConverter implements AttributeConverter<MedioDeComunicacion, String> {
    @Override
    public String convertToDatabaseColumn(MedioDeComunicacion medioDeComunicacion) {
        return medioDeComunicacion.getClass().getSimpleName();
    }

    @Override
    public MedioDeComunicacion convertToEntityAttribute(String s) {
        if(s.equals("Email"))
            return new Email();
        else if(s.equals("Telegram"))
            return new Telegram();
          else if(s.equals("WhatsApp"))
              return new WhatsApp();
        return null;
    }
}
