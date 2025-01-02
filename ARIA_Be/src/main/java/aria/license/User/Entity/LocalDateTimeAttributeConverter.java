package aria.license.User.Entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, String> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String convertToDatabaseColumn(LocalDateTime attribute) {
        return (attribute == null ? null : attribute.format(FORMATTER));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String dbData) {
        return (dbData == null ? null : LocalDateTime.parse(dbData, FORMATTER));
    }
}
