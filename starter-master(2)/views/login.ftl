<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">


        <h1>Formulaire de connexion des profs</h1>
        <#if id?? >
            Connexion en cours<br>
            firstName: ${professeurs.firstName}<br>
            lastName: ${professeurs.lastName}<br>
        <#else>
            <form action="/login" method="post">
                <div>Id du professeur:</div>
                <input type="text" id="id" name="id" required/>
                <br/><br/>
                <div>password:</div>
                <input type="password" id="password" name="password" required/>
                <br/><br/>
                <input type="submit" value="Submit"/>
                <input type="reset" value="Reset"/>
            </form>
        </#if>
    </body>
</html>

