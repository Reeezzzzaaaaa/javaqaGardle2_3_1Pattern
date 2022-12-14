package сardDelivery.data;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

@UtilityClass
public class DataGenerator {

    @UtilityClass
    public static class Data {
        public static RegistrationInfo generateInfo(String locale) {
            Faker faker = new Faker(new Locale(locale));
            String[] center = {"Брянск", "Смоленск", "Курск", "Белгород", "Москва"};
            Random random = new Random();
            int city = random.nextInt(center.length);
            return new RegistrationInfo(
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber(),
                    center[city]);
        }

        public static String generateDate(int days) {
            return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }
}

