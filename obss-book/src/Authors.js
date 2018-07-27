import React from 'react'
import * as AuthorAPI from './AuthorAPI'
class Authors extends React.Component{

    constructor(props) {
        super(props)
        this.state = ({ authors: [] })
    }
    componentDidMount() {
        console.log(this.state.authors)
        AuthorAPI.getAll().then((authors) => {
            if (!authors || authors.hasOwnProperty('error')) {
                this.setState({ authors: [] });
            } else {
                this.setState({ authors: authors });
            }
            console.log(authors)
        });
    }
    render(){
        return(
            <div>
                <h3>List Of Author</h3>
                <form >
                
                <div class="row">
                    <div>{this.state.authors.map(function(authors,i){
                        return (
                            
                                <div class="col-sm-3">
                                    <hr/>
                                    <p style={{color:'#009688'}}><b>Author: </b>{authors.name} {authors.surname}</p>
                                    <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style={{width:'100%'}} alt="Image"/>
                                    <hr/> 
                                </div>  
                                                       
                    )
                    })}</div>                   

                </div>
                </form>


            </div>

        )
    }
}
export default Authors