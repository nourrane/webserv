<#ftl encoding="utf-8">

<head>
    <link href="/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>

<body xmlns="http://www.w3.org/1999/html">

    <div id="main">
    <br/>

        <header>
            <h1>Création Gommette</h1>
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

            <form action="/gommettes/create" method="post">

            <div>
                <label for="Nom de la gommette">Nom de la gommette :</label>
                <input type="text" name="name" required/>
            </div>
            <br/>
            <div>
                <label for="Description de la gommette">Description de la gommette :</label>
                <input type="text" name="description" required/>
            </div>
            <br/>
            <div>
                <label for="Couleur de la gommette">Couleur de la gommette :</label>
                <input type="text" name="color" required/>
            </div>
            <br/>
            <div class="b">
                <input class="buttons" type="submit" value="Valider"/>
                <input class="buttons" type="reset" value="Réinitialiser"/>
            </div>
        </form>
        <a href="/gommettes"> Retour à la page précédente</a> <br/>
    </div>

</body>

</html>