package recipe.app.rest.converters;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.web.multipart.MultipartFile;

@Converter
public class ImageConverter implements AttributeConverter<MultipartFile, byte[]>{

	@Override
	public byte[] convertToDatabaseColumn(MultipartFile attribute) {
		// TODO Auto-generated method stub
		
		System.out.println("entrooooooooooooooooooooo");
		try {
			return attribute.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public MultipartFile convertToEntityAttribute(byte[] dbData) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
