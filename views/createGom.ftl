<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">
 <h1>Espace gommettes</h1>

    <p>Espace création gommette</p>
        <form action="/gommettes/create" method="post">

        <div>Nom de la gommette:</div>
        <input type="text" name="name" required/>
        <br/><br/>
        <div>Description de la gommette:</div>
        <textarea type="text" name="description" required/>
        </textarea>
        <br/><br/>
        <div>Couleur de la gommette:</div>
        <input type="text" name="color" required/>
        <br/><br/>
        <input type="submit" value="Submit"/>
        <input type="reset" value="Reset"/>
    </form>
    
    <a href="/gommettes"> Retour à la page précédente</a> <br/>


</body>

</html>