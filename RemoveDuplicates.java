public class RemoveDuplicates {

    public static void Deleteduplicate(int idx, String str, StringBuilder newstr, boolean map[] ) {

        //Base Case 

        if ( idx == str.length() ) {
            System.out.println(newstr);
            return;
        }

        // KAAM 

        char currchar = str.charAt(idx);
        if(map[currchar-'a'] == true ) {

            Deleteduplicate(idx+1, str, newstr, map);

        } else {
            map[currchar-'a'] = true;
            Deleteduplicate(idx+1, str, newstr.append(currchar), map);
        }
    }
    public static void main(String args[]) {

        String str = "ammmmiiiittttttt";
        Deleteduplicate(0, str, new StringBuilder(""), new boolean[26]);

    }
}
