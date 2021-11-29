package com.oswizar.obtest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.oswizar.entity.Course;
import com.oswizar.entity.Student;
import com.oswizar.entity.Teacher;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class FastjsonTest {


    Logger log = LoggerFactory.getLogger(this.getClass());
    //json字符串-简单对象型
    private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
    //json字符串-数组类型
    private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12}," +
            "{\"studentName\":\"lucy\",\"studentAge\":15}]";
    //复杂格式json字符串
    private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":" +
            "{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12}," +
            "{\"studentName\":\"lucy\",\"studentAge\":15}]}";


    /**
     * json字符串-简单对象型与JSONObject之间的转换
     */
    @Test
    public  void testJSONStrToJSONObject(){

        JSONObject jsonObject = JSON.parseObject(JSON_OBJ_STR);
        //JSONObject jsonObject1 = JSONObject.parseObject(JSON_OBJ_STR); //因为JSONObject继承了JSON，所以这样也是可以的

        System.out.println(jsonObject.get("studentName")+":"+jsonObject.get("studentAge"));
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.toJSONString());

    }


    /**
     * json字符串与JSONArray之间的转换
     */
    @Test
    public  void testJSONStrToJSONArray(){

        JSONArray jsonArray = JSON.parseArray(JSON_ARRAY_STR);
        System.out.println("解析字符串得到的对象: " + jsonArray);
        //JSONArray jsonArray1 = JSONArray.parseArray(JSON_ARRAY_STR);//因为JSONArray继承了JSON，所以这样也是可以的

        //遍历方式1
        int size = jsonArray.size();
        System.out.println("遍历方式1:");
        for (int i = 0; i < size; i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));
        }

        //遍历方式2
        System.out.println("遍历方式2:");
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));
        }
    }

    /**
     * 复杂json格式字符串与JSONObject之间的转换
     */
    @Test
    public  void testComplexJSONStrToJSONObject(){

        JSONObject jsonObject = JSON.parseObject(COMPLEX_JSON_STR);
        //JSONObject jsonObject1 = JSONObject.parseObject(COMPLEX_JSON_STR);//因为JSONObject继承了JSON，所以这样也是可以的

        System.out.println("通过字符串转换的json对象为: " + jsonObject);

        String teacherName = jsonObject.getString("teacherName");
        Integer teacherAge = jsonObject.getInteger("teacherAge");
        JSONObject course = jsonObject.getJSONObject("course");
        JSONArray students = jsonObject.getJSONArray("students");

        System.out.println(teacherName);
        System.out.println(teacherAge);
        System.out.println(course);
        System.out.println(students);
        System.out.println(students.getJSONObject(1));

    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * json字符串-简单对象与JavaBean_obj之间的转换
     */
    @Test
    public  void testJSONStrToJavaBeanObj(){
        //并不能强制转换
//        Object student1 = JSON.parseObject(JSON_OBJ_STR);
//        Student s = (Student)student1;
//        log.info(s.toString());

        Student student = JSON.parseObject(JSON_OBJ_STR, new TypeReference<Student>() {});
        //Student student1 = JSONObject.parseObject(JSON_OBJ_STR, new TypeReference<Student>() {});//因为JSONObject继承了JSON，所以这样也是可以的

        System.out.println(student.getStudentName()+":"+student.getStudentAge());

    }


    /**
     * json字符串-数组类型与JavaBean_List之间的转换
     */
    @Test
    public  void testJSONStrToJavaBeanList(){

        ArrayList<Student> students = JSON.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});
        //ArrayList<Student> students1 = JSONArray.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});//因为JSONArray继承了JSON，所以这样也是可以的

        for (Student student : students) {
            System.out.println(student.getStudentName()+":"+student.getStudentAge());
        }
    }



    /**
     * 复杂json格式字符串与JavaBean_obj之间的转换
     */
    @Test
    public  void testComplexJSONStrToJavaBean(){

        Teacher teacher = JSON.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});
        //Teacher teacher1 = JSON.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});//因为JSONObject继承了JSON，所以这样也是可以的
        String teacherName = teacher.getTeacherName();
        Integer teacherAge = teacher.getTeacherAge();
        Course course = teacher.getCourse();
        List<Student> students = teacher.getStudents();
    }


}
