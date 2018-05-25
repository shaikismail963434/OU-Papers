-dontwarn org.apache.http.**
-keep class com.firebase.** { *; }
-keep class org.apache.** { *; }
-keepnames class com.fasterxml.jackson.** { *; }
-keepnames class javax.servlet.** { *; }
-keepnames class org.ietf.jgss.** { *; }
-dontwarn org.apache.**
-dontwarn org.w3c.dom.**


-ignorewarnings
-keep class * {
    public private *;
}
-keepclasseswithmembernames class * {
    native <methods>;
}
-keep public class com.google.android.gms.ads.**{
   public *;
}
# For old ads classes
-keep public class com.google.ads.**{
   public *;
}

# For mediation
-keepattributes *Annotation*

# Other required classes for Google Play Services
# Read more at http://developer.android.com/google/play-services/setup.html
-keep class * extends java.util.ListResourceBundle {
   protected Object[][] getContents();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
   public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
   @com.google.android.gms.common.annotation.KeepName *;
}

-keepnames class * implements android.os.Parcelable {
   public static final ** CREATOR;
}

-keep class com.tozny.crypto.android.AesCbcWithIntegrity$PrngFixes$* { *; }

-dontwarn com.google.android.gms.internal.zzhu

-keep class com.google.android.gms.internal.** { *; }

# Add this global rule
-keepattributes Signature
