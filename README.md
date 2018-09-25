# jersey-core
maven repository


## Description
* Jerseyのアプリケーションで使用するモジュール
* WebApplicationExceptionMapperを使用することで、アプリケーション内で発生させたExceptionのJsonがレスポンスボディに入る

## Usage
```
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        packages(this.getClass().getPackage().getName());
        register(WebApplicationExceptionMapper.class);
    }
}
```

```
@Path("subjects")
public class SubjectResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BffSubjectRes> getSubjectList() {
        throw new BadRequestException("exception message");
        
        // この場合、以下のJsonがレスポンスボディになる
        {
          status: 400,
          message: "exception message"
        }
    }
}
```

## Install
* maven
```
<dependencies>
    <dependency>
        <groupId>miyakawalab.tool</groupId>
        <artifactId>jersey-core</artifactId>
        <version>${version}</version>
    </dependency>
</dependencies>
<repositories>
    <repository>
        <id>mongodb-dao</id>
        <url>https://raw.github.com/908ab/jersey-core/mvn-repo/</url>
    </repository>
</repositories>
```

## Version
> 1.0