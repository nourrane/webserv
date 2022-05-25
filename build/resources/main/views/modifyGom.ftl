<#ftl encoding="utf-8">

<head>
    <link href="/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>

<body xmlns="http://www.w3.org/1999/html">
<div id="main">
        <br/>

            <header>
                <h1>Modification gommette</h1>
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

                <form action="/gommettes/modify" method="post">

                <div>
                    <label for="Identifiant de la gommette">Identifiant de la gommette :</label>
                    <select name="id" required/>
                        <#list gommettes as gommette>
                            <option value=${gommette.id}>${gommette.id}</option>
                        </#list>
                    </select>
                </div>
                <br/>
                <div>
                    <label for="Nouvelle description de la gommette">Nouvelle description de la gommette :</label>
                    <input type="text" name="description" required/>
                </div>
                <br/>
                <div>
                    <label for="Nouvelle couleur de la gommette">Nouvelle couleur de la gommette :</label>
                    <input type="text" name="color" required/>
                </div>
                <br/><br/>
                <div class="b">
                <input class="buttons" type="submit" value="Valider"/>
                <input class="buttons" type="reset" value="Réinitialiser"/>
                </div>
            </form>
            <br/>
            <footer>
            <a class="buttons" href="/gommettes"> Retour</a>
            </footer> 
            <br/>
        </div>

</body>

</html>