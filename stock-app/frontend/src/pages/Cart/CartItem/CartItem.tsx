import React, { FC, ReactElement, useEffect, useState } from "react";
import { Card, Col, InputNumber, Row, Typography } from "antd";

import { ProductResponse } from "../../../types/types";
import RemoveButton from "./RemoveButton";
import CartItemInfo from "./CartItemInfo";

type PropsType = {
    perfume: ProductResponse;
    perfumeInCart: number;
    onChangeProductItemCount: (perfumeId: number, inputValue: number) => void;
    deleteFromCart: (perfumeId: number) => void;
};

const CartItem: FC<PropsType> = ({
    perfume,
    perfumeInCart,
    onChangeProductItemCount,
    deleteFromCart
}): ReactElement => {
    const [perfumeCount, setProductCount] = useState(1);

    useEffect(() => {
        setProductCount(perfumeInCart);
    }, []);

    const handleProductsCount = (value: number | null): void => {
        setProductCount(value!);
        onChangeProductItemCount(perfume.id, value!);
    };

    return (
        <Card className={"cart-item"}>
            <Row gutter={16}>
                <CartItemInfo perfume={perfume} />
                <Col span={8}>
                    <Row gutter={8}>
                        <Col span={12}>
                            <InputNumber
                                min={1}
                                max={99}
                                value={perfumeCount}
                                onChange={handleProductsCount}
                            />
                        </Col>
                        <Col span={12}>
                            <RemoveButton perfumeId={perfume.id} deleteFromCart={deleteFromCart} />
                        </Col>
                    </Row>
                    <Row style={{ marginTop: 16 }}>
                        <Typography.Title level={4}>${perfume.price * perfumeCount}</Typography.Title>
                    </Row>
                </Col>
            </Row>
        </Card>
    );
};

export default CartItem;
