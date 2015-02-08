package info.riado.utils;

import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author ivan
 */
public class FileResourceExtractor {

	public static String getResourceAsString(Resource res, String encoding) throws IOException {
		try (FileInputStream stream = new FileInputStream(res.getFile())) {
			FileChannel fc = stream.getChannel();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
			return Charset.forName(encoding).decode(bb).toString();
		}
	}

	public static String getResourceAsString(Resource res) throws IOException {
		return getResourceAsString(res, "UTF-8");
	}

}
