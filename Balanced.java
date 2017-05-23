public class Balanced {

    public static boolean answer(String input) {
        
        // null is balanced
        if (input == null) {
            return true;
        }
       
        String filtered = input.replaceAll("[^\\(\\{\\[\\)\\}\\]]", "");       
        
        // strlen 0 is balanced
        if (filtered.length() < 1) {
            return true;
        }
        
        // odds are imbalanced
        if (filtered.length() % 2 > 0) {
            return false;    
        }
        
        int complete = 0;
        char needle;
        
        for (int i = 0; i < filtered.length() - 1; i++) {
            //System.out.println("iter: " + i);
            
            needle = filtered.charAt(i);
            
            // don't bother matching rights
            if (isRight(needle)) {
                continue;
            }
            
            if (search(needle, filtered.substring(i + 1), 0)) {
                complete++;    
            } else {
                complete = 0;
                break;
            }
        }
        
        return (complete > 0);
    }
    
    private static boolean search(char needle, String haystack, int acc) {
        
        char toMatch = haystack.charAt(0);
        boolean isMatch = match(needle, toMatch);
        
        /* 
        System.out.println("needle: " + needle);
        System.out.println("haystack: " + haystack);
        System.out.println("match char: " + toMatch);
        System.out.println("len hs: " + haystack.length());
        System.out.println(toMatch + " is right: " + isRight(toMatch));
        System.out.println("is match: " + match(needle, toMatch));
        System.out.println("----------");*/

        
        if (isRight(toMatch) && isMatch) {
           return true;
        } else if (isRight(toMatch) && !isMatch && (haystack.length() == 1 || acc == 0)) {
           return false;
        } else {
            if (isLeft(toMatch)) {
                return search(needle, haystack.substring(1), acc+1);
            } else {
                return search(needle, haystack.substring(1), acc);
            }
        }
    }
    
    private static boolean match(char left, char right) {
        
        return ((left == "{".charAt(0) && right == "}".charAt(0)) ||
         (left == "[".charAt(0) && right == "]".charAt(0)) ||
         (left == "(".charAt(0) && right == ")".charAt(0)));
    }
    
    private static boolean isLeft(char input) {
        
        if (input == "{".charAt(0)) {
           return true; 
        }

        if (input == "(".charAt(0)) {
            return true; 
        }

        if (input == "[".charAt(0)) {
            return true; 
        }
        
        return false;
    }
    
    private static boolean isRight(char input) {
        
        if (input == "}".charAt(0)) {
           return true; 
        }

        if (input == ")".charAt(0)) {
            return true; 
        }

        if (input == "]".charAt(0)) {
            return true; 
        }
        
        return false;
    }
}       
