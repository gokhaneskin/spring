import React from "react";
import {Switch,Route,Redirect} from "react-router-dom";
import Books from "./Books";
import Authors from "./Authors"

const AppRouter=()=>(
    <Switch>
        <Route exact path="/" render={()=><Redirect replace to="links"/>}/>
        <Route path="/books" component={Books}/>
        <Route path="/authors" component={Authors}/>
    </Switch>
); 
export default AppRouter;