<#ftl encoding="utf-8">


<body xmlns="http://www.w3.org/1999/html">
 <h1>Espace gommettes</h1>

      <p>Espace modification gommette</p>
        <form action="/gommettes/modify" method="post">

        <div>Identifiant de la gommette :</div>
        <select name="id" required >
            <#list gommettes as gommette>
                <option value=${gommette.id}>${gommette.id}</option>
            </#list>
        </select>
        <br/><br/>
        <div>Nouveau nom de la gommette :</div>
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