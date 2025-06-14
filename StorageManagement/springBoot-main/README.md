# springBoot

# Model
[Document of Spring Boot Model Manual](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/ui/Model.html)

```
Model addAttribute(Object attributeValue)
```
Add the supplied attribute to this Map using a generated name.

Example
```
ArrayList<User> listOfArray = new ArrayList<User>();
		userAiven ua = new userAiven();
		listOfArray = ua.userAivenList();

		model.addAttribute("listOfArray", listOfArray);
```
# Controller

```
//this to assign Controller
@Controller
public class SongListController {
    @GetMapping("/songlist")

    public String songlist(Model model){

        ArrayList<Song> songList = new ArrayList<Song>();
        songAiven sa = new songAiven();
        songList = sa.songAivenList();
        model.addAttribute("ListOfSong", songList);

        //data to View is ${ListOfSong}
        
       //return view is songList
        return "songlist";

    }

    
}
```
