class Developer {

    List languages = []

    def coffee() {
        println "turning coffee into code..."
    }

    def methodMissing(String name, args) {
        println "method was called for ${name}"

        boolean languageExists = languages.find { it == name.split("write")[1] }
        if( languageExists ) {
            String language = name.split("write")[1]
            if( languages.contains(language) ) {
                def writeCode = { ->  println "I enjoy writing code in ${language}"}
                metaClass."$name" = writeCode
                return writeCode()
            }
        }
    }
}

ExpandoMetaClass.enableGlobally()

Developer dan = new Developer()
dan.coffee()
dan.languages << "Groovy"
dan.languages << "Java"
dan.languages << "JavaScript"
dan.writeGroovy()
dan.writeJava()
dan.writeJavaScript()
dan.writePhp()