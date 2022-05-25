<#ftl encoding="utf-8">

<head>
    <link href="/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>

<body xmlns="http://www.w3.org/1999/html">
    <div id="main">
    <br/>

        <header>
            <h1>Formulaire de connexion des profs</h1>
        </header>
        <br/>
     <nav>
      <ul>
          <li><a href="/index"><i class="fa fa-home"></i></a></li>
          <li><a href="/professeurs">Professeurs</a></li>
          <li><a href="/eleves">Élèves</a></li>
          <li><a href="/gommettes">Gommettes</a></li>
          <li><a href="/elevesGom">Attributions</a></li>
      </ul>
  </nav>

    <#if id?? >
        Vous êtes connecté<br>
        Prénom: ${professeurs.firstName}<br/>
        Nom: ${professeurs.lastName}<br/>
        <a class="buttons" href="/removeCookies">Deconnexion</a>
    <#else>
        <#if incorrect??> 
        <p class="error">Votre nom d'utilisateur ou mot de passe est incorrect. <p>
        </#if>
        <form action="/login" method="post">

        <div>
            <label for="Identifiant du professeur">Identifiant du professeur :</label>
            <input type="text" id="id" name="id" required/>
        </div>
        <br/>
        <div>
            <label for="Mot de passe">Mot de passe :</label>
            <input type="password" id="password" name="password" required/>
        </div>
        <br/><br/>
        <div class="b">
            <input class="buttons" type="submit" value="Valider"/>
            <input class="buttons" type="reset" value="Réinitialiser"/>
        </div>
        </form>
    </#if>
    </div>


</body>
</html>


