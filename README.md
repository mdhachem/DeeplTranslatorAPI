# DeeplTranslatorAPI

<p>The <strong>Deepl Translator API</strong> is a language translation API that allows other computer programs to send texts and documents to DeepL's servers and receive high-quality translations.</p>

### Supported Documents Type:
<ul>
  <li>Docs (Microsoft Word)</li>
  <li>PPT (Microsoft PowerPoint)</li>
  <li>XLSX (Microsoft Excel)</li>
  <li>CSV</li>
  <li>PDF</li>
  <li>XML</li>
  <li>JSON</li>
</ul>

## Requirements

API authentication key [Pro Account].

Java 11 or later.

## Installation

### Gradle users

Add this dependency to your project's build file:

```
not ready yet.
```

### Maven users

Add this dependency to your project's POM:

```
not ready yet.
```

# Usage

Be careful not to expose your key, for example when sharing source code.

```java


import java.util.Arrays;
import java.util.List;

import com.mdhachem.translator.SourceLanguage;
import com.mdhachem.translator.TargetLanguage;
import com.mdhachem.translator.service.Translator;

public class Main {
    public static void main(String[] args){
       Translator translator = new Translator.Builder().setAuthKey("00e8b6fe-...").build();
		List<String> texts = Arrays.asList("Bonjour", "je peux t'appeler");
		System.out.println(translator.translate(texts,SourceLanguage.FRENCH,TargetLanguage.ENGLISH_AMERICAN)); // [Hello, I can call you]
		System.out.println(translator.translate("mes amis", SourceLanguage.FRENCH, TargetLanguage.ENGLISH_AMERICAN)); // my friends
    }
}
```
