<main>
    <header>
        <nav class="nav_menu">
            <ul class="menu_containerul">   
                <li class="menu_containerli">
                    <a href="">Hi, 
                    <% 
                    String firstName = (String) session.getAttribute("firstName");
                    if (firstName != null) {
                        out.print(firstName);
                    }
                    %>
                    </a>
                </li>
                <li class="menu_containerli"><a href="">Home</a></li>             
                <li class="menu_containerli"><a href="">Administration</a>    
                    <ul class="secondlevelul_menu">
                        <li class="menu_containerli"><a href="">Front Page Content</a>
                            <ul class="submenu">
                                <li class="submenu_containerli"><a href="Main_Contents/content-entry.jsp">Add content</a></li>
                                <li class="submenu_containerli"><a href="Main_Contents/deletecontent.jsp">Delete content</a></li>
                                <li class="submenu_containerli"><a href="Main_Contents/editcontent.jsp">Edit content</a></li>
                            </ul>                
                        </li>    
                        <li class="menu_containerli"><a href="addprivledges.jsp">Update User Privileges</a></li>
                        <li class="menu_containerli"><a href="allprivledges.jsp">View User Privileges</a></li>    
                    </ul> 
                </li>
                <li class="menu_containerli"><a href="#">My Profile</a>        
                    <ul class="secondlevelul_menu">
                        <li class="menu_containerli"><a href="AccountSettings/changepassword.jsp">Change Password</a></li>  
                        <li class="menu_containerli"><a href="AccountSettings/changeemail.jsp">Change Email</a></li>
                        <li class="menu_containerli"><a href="AccountSettings/deleteaccount.jsp">Delete Account</a></li>    
                    </ul>
                </li>    
                <li class="menu_containerli"><a href="">CyberSecurity Community</a>        
                    <ul class="secondlevelul_menu">
                        <li class="menu_containerli"><a href="">Write an Article</a></li>  
                        <li class="menu_containerli"><a href="auth/mlogin.jsp">View Articles</a></li>
                        <li class="menu_containerli"><a href="http://localhost:8000/CS372-Fall2024-GroupA/CyberAttackServlet">Top Countries Attacks</a></li>                 
                    </ul>
                </li>  
                <li class="menu_containerli"><a href="#">Contact</a></li>            
                <li class="menu_containerli"><a href="#">About Us</a></li>
                <li class="menu_containerli"><a href="#">Help</a></li>
                <li class="menu_containerli"><a href="Login/logout.jsp">Logout</a></li>
            </ul>
        </nav>
    </header>
</main>