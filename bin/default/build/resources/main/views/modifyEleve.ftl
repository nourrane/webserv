<#ftl encoding="utf-8">

<head>
    <link href="/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>

<body xmlns="http://www.w3.org/1999/html">
    <div id="main">
        <br/>

            <header>
                <h1>Modification élève</h1>
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

                <form action="/eleves/modify" method="post">

                <div>
                    <label for="Identifiant de l'élève">Identifiant de l'élève :</label>
                    <select name="id" required/>
                        <#list eleves as eleve>
                            <option value=${eleve.id}>${eleve.id}</option>
                        </#list>
                    </select>
                </div>
                <br/>
                <div>
                    <label for="Nouveau prénom de l'élève">Nouveau prénom de l'élève :</label>
                    <input type="text" name="firstname" required/>
                </div>
                <br/>
                <div>
                    <label for="Nouveau nom de l'élève">Nouveau nom de l'élève :</label>
                    <input type="text" name="lastname" required/>
                </div>
                <br/><br/>
                <div class="b">
                <input class="buttons" type="submit" value="Valider"/>
                <input class="buttons" type="reset" value="Réinitialiser"/>
                </div>
            </form>
             <br/>
            <footer>
            <a class="buttons" href="/eleves"> Retour</a>
            </footer>            
            <br/>
        </div>

</body>

</html>


