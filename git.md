# Git 版本管理 

## dos操作 

​    win+R  打开 运行窗口，输入cmd  ,打开dos窗口 

  盘符切换：  盘符:

 切换目录：  cd  目录

> cd 输入目录时，可以按tab键补全

 创建目录： mkdir 目录名 

 查看当前目录下的所有文件：   dir   

## Git常用命令

1.  git init  将当前文件夹加入到git仓库管理中 

2. git status  查看版本管理状态  

3. git add  文件1  文件2....   将文件的改变的添加到暂存区中  多个文件之间用空格隔开  

4. git rm --cached 文件1  文件2...   将暂存区中的文件移除  多个文件之间用空格隔开    (rm----remove )

   > git restore --staged 文件   将暂存区中修改过的文件  放弃了 

5. git add .  将所有改变都提交到暂存区中  

6. git commit -m '提交记录描述'    将暂存区中的文件的改变提到到仓库中  

7. git  restore 文件。。。   放弃文件的改变  

8. git remote add origin https://gitee.com/nieps/gitdemo_208.git    将本地仓库与远程仓库建立联系  origin 是远程仓库在本地的名称   

9. git  log 查看提交历史 

10. git reset  --hard  commit_id  恢复到指定的历史版本  （可以只取前7位）

11. git reflog  查看提交历史（把版本恢复到未来的指定版本上 ）

12. git remote -v  查看远程分支信息  

13. git remote add 远程分支名称   远程分支的地址   建立本地仓库与远程仓库的联系 

14. git remote rm 远程分支名称   解除与远程分支仓库的关系

15. git push -u 远程分支名称   本地分支名称(默认是master)  初次提交   

16. git push -f  远程分支名称   本地分支名称(默认是master)    -f force  强制推送  

17. git clone 远程分支地址  克隆远程分支 

18. git pull 远程分支名称  本地分支名称(默认master)   将远程的代码更新到本地  

    > :q!    退出编辑

19. git branch   查看当前所有的分支  

20. git checkout -b 分支名称  (dev  devlopment)   创建并切换到新的分支上  

    > 上面的一条命令相当 于执行以下两条命令：
    >
    > git branch 分支名称   创建分支 
    >
    > git checkout 分支名称   切换到指定分支上 
    
    git switch -c 分支名称   创建并切换到新的分支上  
    
    > git switch 分支名称   切换到指定分支上 

21. git checkout 分支名称   切换到指定的分支上  

22. git merge 分支名称    将指定的分支合并到当前分支 

23. git branch -d 分支名称   删除指定分支   

24. git push 远程分支名称   本地要推送的分支名称(如dev) :  新分支在远程上的名称    把本地的非master分支推送到远程  

25. git push 远程分支名称   --delete 要删除的远程分支名称      删除远程分支  

26. git tag  标签名称   创新一个新的标签 指向当前最新的commit_id   

    > git tag 标签名称   commit_id     创新一个新的标签 指向指定的commit_id

27. git tag     查看当前所有的标签  

28. git push 远程分支名称   标签名 将指定 的标签推送到远程   

29. git push 远程分支名称  --tags   将所有未推送的标签全部推送到远程   

30. git tag -d 标签名称   删除指定 的标签   

31. git  push 远程分支名称   :refs/tags/远程标签名称     删除远程标签名称  

​    

​    

​    

​    

​    

​    

