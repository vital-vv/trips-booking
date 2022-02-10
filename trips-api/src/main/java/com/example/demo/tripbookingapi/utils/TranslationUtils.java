package com.example.demo.tripbookingapi.utils;

import com.example.demo.tripbookingapi.domain.enumeration.Language;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TranslationUtils {

  public <T> String getTranslation(Map<Language, T> translations, Language language, Function<T, String> mapper) {
    return Optional.ofNullable(translations.get(language))
        .map(mapper)
        .orElse(null);
  }
}
