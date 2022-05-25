<#ftl encoding="utf-8">
<head>
    <link href="/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>

<body xmlns="http://www.w3.org/1999/html">

    <div id="main">
    <br/>

        <header>
            <h1>Ajout de gommette à un élève</h1>
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

            <form action="/elevesGom/create" method="post">


                <label for="idEleve">Identifiant de l'élève</label>
                <select name="idEleve" required >
                    <#list eleves as e>
                        <option value=${e.id}>${e.id}</option>
                    </#list>
                </select>
            <br/>
            </br>
                <label for="idGom">Identifiant de la gommette</label>
                <select name="idGom" required >
                    <#list goms as gom>
                        <option value=${gom.id}>${gom.id}</option>
                    </#list>
                </select>
            <br/>
                <div>Date :</div>
                <input type="date" name="date" required/>
            <br/>
                <label for="Motif">Motif :</label>
                <input type="text" name="motif" required/>
            <br/><br/>
            <div class="b">
               <input class="buttons" type="submit" value="Valider"/>
                <input class="buttons" type="reset" value="Réinitialiser"/>
            </div>
        </form>
        <br/>
        <footer>
        <a class="buttons" href="/elevesGom"> Retour </a> 
        </footer><br/>
    </div>

</body>

</html>