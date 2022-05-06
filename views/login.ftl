<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">
    <nav>
        <ul>
          <li><a href="/index">Index</a></li>
          <li><a href="/professeurs">Espace Professeurs</a></li>
          <li><a href="/eleves">Liste Elèves</a></li>
          <li><a href="/gommettes">Liste Gommettes</a></li>
            <li><a href="/elevesGom">Liste d'attribution des gommettes à un élève</a></li>
        </ul>
    </nav>

    <h1>Formulaire de connexion des profs</h1>
    <#if id?? >
        Connexion en cours<br>
        firstName: ${professeurs.firstName}<br>
        lastName: ${professeurs.lastName}<br>
        <a href="/removeCookies">Deconnexion</a>
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

