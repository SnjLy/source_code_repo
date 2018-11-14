package gitlab;

import com.alibaba.fastjson.JSON;
import org.gitlab4j.api.*;
import org.gitlab4j.api.models.*;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>description</>
 * Created by yehao on 2018/1/12.
 */
public class Gitlab4jWrapper {

    public static String userName = "skylab@163.com";
    public static String password = "skylab@password";

    public static final String url = "https://git.8888.cn";


    public static void main(String[] args) {

        try {
            GitLabApi gitLabApi = GitLabApi.login(url, userName, password, true);

            Constants.TokenType tokenType = gitLabApi.getTokenType();
            String authToken = gitLabApi.getAuthToken();
            System.out.println(tokenType + "___" + authToken);
            GitLabApi api = new GitLabApi(url, tokenType, authToken);
            ProjectApi projectApi = api.getProjectApi();
            List<Project> projects = projectApi.getProjects();


            UserApi userApi = api.getUserApi();
            User currentUser = userApi.getUser(userName);
            System.out.println("user:" + JSON.toJSONString(currentUser));

            System.out.println("size:"+projects.size() +"----"+JSON.toJSONString(projects));
            for (Project project : projects){
                if ("skylab-gitlab-test".equals(project.getName())){

                    System.out.println(JSON.toJSONString(project));
                    List<Member> members = projectApi.getMembers(project.getId());
                    if (CollectionUtils.isEmpty(members)){
                        Member member = projectApi.addMember(project.getId(), currentUser.getId(), AccessLevel.DEVELOPER);
                        System.out.println("member:" + JSON.toJSONString(member));
                        members = projectApi.getMembers(project.getId());
                    }
                    System.out.println("members:" + JSON.toJSONString(members));




                    Group group = api.getGroupApi().getGroup(project.getNamespace().getPath());
                    System.out.println("group:"+ JSON.toJSONString(group));
                    members = api.getGroupApi().getMembers(group.getId());
                    System.out.println("members:" + JSON.toJSONString(members));

                    RepositoryFileApi repositoryFileApi = api.getRepositoryFileApi();
                    RepositoryFile file = repositoryFileApi.getFile("README.md", project.getId(), "master");
                    if(null == file) {
                        file =new RepositoryFile();
                        file.setFileName("README.md");
                        file.setContent("create file:" + project.getName() + "author:" + userName);
                        file.setFilePath("README.md");

                        repositoryFileApi.createFile(file, project.getId(), "master", "init submit");
                        project.setDefaultBranch("master");
                    }


                    String defaultBranch = project.getDefaultBranch();
                    System.out.println("defaultBranch:" + defaultBranch);

                    RepositoryApi repositoryApi = api.getRepositoryApi();
                    repositoryApi.createBranch(project.getId(),"yehao_test_v1", defaultBranch);
                    List<Branch> branches = repositoryApi.getBranches(project.getId());
                    System.out.println("branches:" + JSON.toJSONString(branches));



                }
            }

        } catch (GitLabApiException e) {
            e.printStackTrace();
        }
    }

}
