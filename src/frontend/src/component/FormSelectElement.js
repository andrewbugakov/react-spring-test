import React,{Component} from 'react';
import { FormGroup,FormControl,ControlLabel, Col} from 'react-bootstrap'

export default class FormSelectElement extends Component {
    render(){
        return(
            <>
                <FormGroup controlId="formControlsSelect">
                    <Col componentClass={ControlLabel} sm={2}>
                        {this.props.label}
                    </Col>
                    <Col sm={10}>
                        <FormControl componentClass="select" defaultValue='-1' 
                        value={this.props.value} placeholder={this.props.placeholder} onChange={(event)=>this.props.onChange(event)}>
                            <option value="-1">Выберите из выпадающего списка</option>
                            {this.props.elems.map(elem=>
                                <option value={elem.id} key={elem.id}>{elem.name}</option>
                            )}
                        </FormControl>
                    </Col>
                </FormGroup>
                
            </>
        );
    }
}