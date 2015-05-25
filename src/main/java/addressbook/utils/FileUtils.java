package addressbook.utils;


import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.apache.commons.lang3.Validate.notNull;

/**
 * Provides set of utils for operating on file
 */
public class FileUtils {

    /**
     * Reads content of file and returns list of its lines
     *
     * @param fileName name of the file from resource directory
     * @return content of the file
     * @throws RuntimeException if file is not found
     * @throws NullPointerException if file name is null
     */
    public static List<String> readLines(String fileName) {
        notNull(fileName);

        URL url = Resources.getResource(fileName);
        try {
            return Resources.readLines(url, Charsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e); // there is nothing I can do at this point
        }
    }

}
