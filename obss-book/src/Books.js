import React from 'react'
import * as BooksAPI from './BooksAPI'
class Books extends React.Component{
    constructor(props) {
        super(props)
        this.state = ({ books: [] })
    }

    componentDidMount() {
        console.log(this.state.books)
        BooksAPI.getAll().then((books) => {
            if (!books || books.hasOwnProperty('error')) {
                this.setState({ books: [] });
            } else {
                this.setState({ books: books });
            }
            console.log(books)
        });
    }

    render() {
        return (
            <div>
                <h3>List Of Book</h3>
                <form >
                
                <div class="row">
                    <div>{this.state.books.map(function(books,i){
                        return (
                            
                                <div class="col-sm-3">
                                    <hr/>
                                    <p style={{color:'#009688'}}><b>Title: </b>{books.title}</p>
                                    <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style={{width:'100%'}} alt="Image"/>
                                    <p style={{color:'#ff9800'}}><b>Author: </b>{books.authorID.name} {books.authorID.surname}</p><br/>
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
export default Books
