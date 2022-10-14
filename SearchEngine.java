import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    ArrayList<String> words = new ArrayList<String>();

    public String handleRequest(URI url) {
        System.out.println("Path: " + url.getPath());
        if (url.getPath().contains(s: "/add")) {
            String[] parameters = url.getQuery().split(regex: "=");
            if (parameters[0].equals(anObject: "s")) {
                words.add(index: 0, parameters[1]);
                return parameters[1] + " added";
            }
        }
        else if (url.getPath().contains(s: "/search")) {
            String[] parameters = url.getQuery().split(regex: "=");
            ArrayList<String> chosenWords = new ArrayList<String>();
            if (parameters[0].equals(anObject: "s" )) {
                for (int i = 0; i < words.size(); i++) {
                    if (words.get(i).contains(parameters[1])) {
                        chosenWords.add(index: 0, words.get(i));
                    }
                }
            }
            return chosenWords.toString();
        }
        else if (url.getPath.equals(anObject: "/")) {
            return "Please add a word or search with keywords!";
        } else {
            return "404 Not Found!";
        }
        return "";
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}