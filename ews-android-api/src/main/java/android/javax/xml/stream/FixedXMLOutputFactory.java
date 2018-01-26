package android.javax.xml.stream;

public abstract class FixedXMLOutputFactory {
	public static XMLOutputFactory newInstance(String factoryId, ClassLoader classLoader) throws FactoryConfigurationError {
        return (XMLOutputFactory) FactoryFinder.find(factoryId, "com.sun.xml.stream.ZephyrWriterFactory", classLoader);
    }
}