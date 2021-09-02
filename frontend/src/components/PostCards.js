import * as React from 'react';
import { useListContext, List, TextField } from 'react-admin';
import { Card, CardContent } from '@material-ui/core';

const cardStyle = {
    width: 300,
    minHeight: 300,
    margin: '0.5em',
    display: 'inline-block',
    verticalAlign: 'top'
};
const PostGrid = () => {
    const { ids, data } = useListContext();
    return (
        <div style={{ margin: '1em' }}>
        {ids.map(id =>
            <Card key={id} style={cardStyle}>
                <img src="https://i0.statig.com.br/bancodeimagens/1z/x4/9z/1zx49zbey799avacjh7509lv0.jpg" width="100%" height="200px" alt=""></img>
                <CardContent>
                    <TextField record={data[id]} source="name" />
                </CardContent>
                <CardContent>
                    Marca: <TextField record={data[id]} source="brand" />
                </CardContent>
                <CardContent>
                    Modelo: <TextField record={data[id]} source="model" />
                </CardContent>
            </Card>
        )}
        </div>
    );
};

const PostCards = (props) => (
    <List title="Vitrine de Carros" {...props}>
        <PostGrid />
    </List>
);

export default PostCards;