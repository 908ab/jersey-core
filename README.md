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

## Version
> 1.0