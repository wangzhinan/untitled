package sort;

import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        System.out.println(hashSet.add("1"));
        System.out.println(hashSet.add("1"));
        System.out.println(hashSet.add("1"));

    }

    @Test
    public void testLinkList() {
        LinkList linkList = new LinkList();
        linkList.insertFirst(22, 2.99);
        linkList.insertFirst(44, 4.99);
        linkList.insertFirst(66, 6.99);
        linkList.insertFirst(88, 8.99);

        linkList.displayList();

        Link link = linkList.find(44);
        if (link != null) {
            System.out.println("link.iData = " + link.iData);
        } else {
            System.out.println("Can't find link");
        }

        linkList.insertAfter(22, new Link(55, 5.99));
        System.out.println("insert");
        linkList.displayList();
        System.out.println("insert after");
        while (!linkList.isEmity()) {
            Link l = linkList.deleteFirst();
            System.out.print("Deleted");
            l.displayLink();
        }
        linkList.displayList();
    }


    @Test
    public void testSwap() {
        Integer a = 56;
        Integer b = 45;
        System.out.println("before：a = " + a + "....b = " + b);
        swapNumber(a, b);
        System.out.println("after : a = " + a + "....b = " + b);
    }


    public void swapNumber(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("swing : a = " + a + "....b = " + b);
    }

    @Test
    public void testProrityQueue() {
        ProrityQueue queue = new ProrityQueue(6);
        StringBuilder sb = new StringBuilder("[");
        int[] array = createArray(6);
        for (int anArray : array) {
            queue.insert(anArray);
        }
        System.out.println(Arrays.toString(array));
        queue.disPlay();
    }

    @Test
    public void testQueue() {
        Queue queue = new Queue(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);

        System.out.println(queue.remove());
        System.out.println(queue.remove());

        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.remove();
        queue.remove();
        queue.insert(80);
        queue.insert(90);
        queue.insert(100);
        queue.insert(110);
        queue.insert(120);

        while (!queue.isEmity()) {
            long n = queue.remove();
            System.out.println(n);
        }
    }

    @Test
    public void testStack() {
        Stack stack = new Stack(10);
        stack.push(45);
        System.out.println(stack.peek());
        stack.push(47);
        stack.push(21);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    @Test
    public void testString() {
        String s = "abcdefgh";
        reverseString(s);
        System.out.println(s);
    }

    @Test
    public void testChangArray() {
        int[] array = createArray(9);
        System.out.println(Arrays.toString(array));
        changeArray(array);
        System.out.println(Arrays.toString(array));
    }


    public void reverseString(String s) {
        System.out.println(s.hashCode());
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            chars[i] = chars[chars.length - 1 - i];
        }
        System.out.println(s.hashCode());
        s = String.valueOf(chars);
        System.out.println("after" + s);
    }


    public void changeArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }


    public int[] createArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }


    @Test
    public void testInfix() {
        String input, output;
        while (true) {
            System.out.println("Enter infix:");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }
            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans();
            System.out.println(output);
        }

    }

    public static String getString() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String result;
        try {
            result = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            result = "";
        }
        return result;
    }

    @Test
    public void testUrl(){
        File file = new File("C:/Users/wangzn/Desktop/新建文件夹/9/url.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            List<String> list = new ArrayList<>();
            Map<String,String> map = new HashMap<>();
            String url = "";
            String filename = "C:/Users/wangzn/Desktop/新建文件夹/9";
            while ((url = bufferedReader.readLine()) != null){
//                map.put(url,filename+"/"+url.substring(url.lastIndexOf("/")));
                save(url,filename+"/"+url.substring(url.lastIndexOf("/")));
                Thread.sleep(5000);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
    }



    ExecutorService service = null;
    public void save(String url,String fileName){
        if (service == null){
            service = Executors.newFixedThreadPool(100);
        }
        service.execute(() -> {
            try {
                URL ur = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) ur.openConnection();
                connection.setRequestProperty("Accept", "text/html");
                connection.setRequestProperty("Accept-Charset", "utf-8");
                connection.setRequestProperty("Accept-Encoding", "gzip");
                connection.setRequestProperty("Accept-Language", "en-US,en");
                connection.setRequestProperty("User-Agent",
                        "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.160 Safari/537.22");
                OutputStream outputStream = new FileOutputStream(fileName);
                InputStream inputStream = connection.getInputStream();
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) != -1 ){
                    outputStream.write(buffer,0,length);
                }
                inputStream.close();
                outputStream.flush();
                outputStream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
